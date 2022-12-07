use std::{io::{self, BufRead}, collections::HashSet};

fn main() {
    let stdin = io::stdin();
    let mut score_total = 0;
    for line in stdin.lock().lines() {
        let line = line.unwrap();
        let len = line.len();
        let (first, second) = line.split_at(len / 2);
        let common = find_first_common(first, second).unwrap();
        let score = letter_score(&common);
        score_total += score;
        println!("{common}: {score} ({score_total})");
    }
    println!("Total: {score_total}")
}

fn find_first_common(first: &str, second: &str) -> Option<char> {
    let chars: HashSet<char> = first.chars().collect();
    for ch in second.chars() {
        if chars.contains(&ch) {
            return Some(ch)
        }
    }
    None
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