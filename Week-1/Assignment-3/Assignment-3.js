let input1 = ['a', 'b', 'c', 'a', 'c', 'a', 'c'];
let input2 = ['e', 'd', 'c', 'd', 'e']

// countAandB
function countAandB(input1) {
    let count = 0;
    for (let i = 0; i < input1.length; i++)
        if (input1[i] === 'a' || input1[i] === 'b') {
            count++;
        }
    return count;
}

console.log(countAandB(input1));
console.log(countAandB(input2));

//toNumber
let indexOfAlphabet = {
    'a': 1,
    'b': 2,
    'c': 3,
    'd': 4,
    'e': 5
}

function toNumber(input2) {
    let num = [];
    for (let i = 0; i < input2.length; i++) {
        num.push(indexOfAlphabet[input2[i]])
    }
    return num;
}

console.log(toNumber(input1));
console.log(toNumber(input2));