use std::io::{self, BufRead};

fn main() {
    let stdin = io::stdin();
    let mut sum = 0;
    let mut totals = Vec::new();
    for line in stdin.lock().lines() {
        let line = line.unwrap();
        if line.is_empty() {
            println!("{}", sum);
            totals.push(sum);
            sum = 0;
        } else {
            sum += line.parse::<i32>().unwrap();
        }
    }
    totals.sort();

    println!("Top 3:");
    println!("1. {}", totals.pop().unwrap());
    println!("2. {}", totals.pop().unwrap());
    println!("3. {}", totals.pop().unwrap());
}