use std::io::{self, BufRead};

#[derive(Debug, PartialEq)]
enum Action {
    Rock, Paper, Scissors,
}

fn main() {
    let stdin = io::stdin();
    let mut sum = 0;
    for line in stdin.lock().lines() {
        let line = line.unwrap();
        let mut line = line.chars();
        let opponent = match line.next().unwrap() {
            'A' => Action::Rock,
            'B' => Action::Paper,
            'C' => Action::Scissors,
            _ => panic!("Unknown opponent input"),
        };
        line.next().unwrap();
        let mine = match line.next().unwrap() {
            'X' => Action::Rock,
            'Y' => Action::Paper,
            'Z' => Action::Scissors,
            _ => panic!("Unknown user input"),
        };
        let score = calc_score(&opponent, &mine);
        sum += score;
        println!("{:?} -> {:?} == {}", opponent, mine, score);
    }
    println!("Total: {}", sum);
}

fn calc_score(opponent: &Action, mine: &Action) -> i32 {
    let score = match mine {
        Action::Rock => 1,
        Action::Paper => 2,
        Action::Scissors => 3,
    };

    if opponent == mine {
        // Draw
        return score + 3;
    }

    if (opponent == &Action::Rock && mine == &Action::Paper) ||
       (opponent == &Action::Paper && mine == &Action::Scissors) ||
       (opponent == &Action::Scissors && mine == &Action::Rock) {
        // Win
        score + 6
    } else {
        // Lose
        score
    }
}