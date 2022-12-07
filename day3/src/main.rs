use std::{io::{self, BufRead}, collections::HashSet};

fn main() {
    let stdin = io::stdin();
    let mut score_total = 0;
    let mut triple_score_total = 0;
    let mut triple_bag_builder = Vec::new();
    for line in stdin.lock().lines() {
        let line = line.unwrap();
        let len = line.len();
        let (first, second) = line.split_at(len / 2);
        let common = find_common(first, second);
        let common = common.iter().next().unwrap();
        let score = letter_score(common);
        score_total += score;
        triple_bag_builder.push(line);
        if triple_bag_builder.len() == 3 {
            let common = find_common(
                triple_bag_builder.get(0).unwrap(),
                triple_bag_builder.get(1).unwrap());
            let common = find_common(
                &common.iter().map(|ch| ch.to_string()).collect::<Vec<String>>().join(""),
                triple_bag_builder.get(2).unwrap());
            for letter in common.iter() {
                triple_score_total += letter_score(letter);
            }
            triple_bag_builder.clear();
            println!("Triple common letter: {:?} ({triple_score_total})", common);
        }
        println!("{common}: {score} ({score_total})");
    }
    println!("Total: {score_total}");
    println!("Triple Total: {triple_score_total}");
}

fn find_common(first: &str, second: &str) -> HashSet<char> {
    let chars: HashSet<char> = first.chars().collect();
    let mut common = HashSet::new();
    for ch in second.chars() {
        if chars.contains(&ch) {
            common.insert(ch);
        }
    }
    common
}

fn letter_score(letter: &char) -> i32 {
    let letter = letter.to_owned();
    match letter {
        letter @ 'a'..='z' => ((letter as u8) - b'a' + 1).into(),
        letter @ 'A'..='Z' => ((letter as u8) - b'A' + 27).into(),
        letter => panic!("Unsupported rucksack item: {}", letter),
    }
}

#[cfg(test)]
mod tests {
    use crate::letter_score;

    #[test]
    fn test_scoring() {
        assert_eq!(letter_score(&'a'), 1);
        assert_eq!(letter_score(&'c'), 3);
        assert_eq!(letter_score(&'A'), 27);
        assert_eq!(letter_score(&'C'), 29);
        assert_eq!(letter_score(&'z'), 26);
        assert_eq!(letter_score(&'Z'), 52);
    }
}