// Assignment count
function count(input) {
    return input.reduce((acc, character) => {
            if (acc[character]) {
                acc[character] += 1;
            } else {
                acc[character] = 1;    
            }
            return acc;
        }, {});
}
let input = ['a', 'b', 'c', 'a', 'c', 'a', 'x'];

console.log(count(input));


// Assignment groupByKey
function groupByKey(input2) {
    return input2.reduce((acc, item) => {
        const key = item.key;
        const value = parseInt(item.value, 10);

        if (acc[key]) {
            acc[key] += value;
        } else {
            acc[key] = value;
        }
        return acc;

    }, {});
};

let input2 = [
    { key: 'a', value: '3'},
    { key: 'b', value: '1'},
    { key: 'c', value: '2'},
    { key: 'a', value: '3'},
    { key: 'c', value: '5'},
];

console.log(groupByKey(input2));