use std::io::{self, BufRead};

fn main() {
    let stdin = io::stdin();
    let mut sum = 0;
    let mut maximum_sum = 0;
    for line in stdin.lock().lines() {
        let line = line.unwrap();
        if line.is_empty() {
            println!("{}", sum);
            maximum_sum = if sum > maximum_sum {sum} else {maximum_sum};
            sum = 0;
        } else {
            sum += line.parse::<i32>().unwrap();
        }
    }
    println!("Maximum: {}", maximum_sum);
}