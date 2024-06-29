// Algorithm Practice
// Binary Search Algorithm

function binarySearchPosition(number, target) {
    let low = 0;
    let high = number.length - 1;

    while (low <= high) {
        let mid = Math.floor((low+high) / 2);

        if (number[mid] === target) {
            return mid;
        } else if (number[mid] < target) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    return -1;
}

console.log(binarySearchPosition([1, 2, 5, 6, 7], 1));
console.log(binarySearchPosition([1, 2, 5, 6, 7], 6));