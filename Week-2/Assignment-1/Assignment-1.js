// max 
function max(numbers) {
    let maximum = numbers[0];
    for (let i = 1; i < numbers.length; i++) {
       if (numbers[i] > maximum) {
            maximum = numbers[i];
       }
    }
    return maximum;
}

console.log(max([1, 2, 4, 5]));
console.log(max([5, 2, 7, 1, 6]));

// findPosition 
function findPostion(numbers, target) {
    for (let i = 0; i < numbers.length; i++) {
        if (numbers[i] === target) {
            return i;
        }
    }
    return -1;
}

console.log(findPostion([5, 2, 7, 1, 6], 5));
console.log(findPostion([5, 2, 7, 1, 6], 7));
console.log(findPostion([5, 2, 7, 7, 7, 1, 6], 7));
console.log(findPostion([5, 2, 7, 1, 6], 8));
