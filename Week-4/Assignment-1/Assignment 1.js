// A. Complete the function below to show a delayed result in the console.
// Hint: You should use setTimeout() for time scheduling.
function delayedResult(n1, n2, delayTime, result) {
    setTimeout(() => {
      let sum = n1 + n2; 
      result(n1+n2);  
    }, delayTime);
}

delayedResult(4, 5, 3000, function (result) {
    console.log(result); // 9 (4+5) will be shown in the console after 3 seconds
}); 
    
delayedResult(-5, 10, 2000, function (result) {
    console.log(result); // 5 (-5+10) will be shown in the console after 2 seconds
});


// B. To implement delayedResult again using promise this time. It should look like:
function delayedResultPromise(n1, n2, delayTime) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                let sum = n1 + n2;
                resolve(sum);
            }, delayTime);
        })
}


delayedResultPromise(4, 5, 3000)
    .then(console.log); // 9 (4+5) will be shown in the console after 3 seconds


// C. To implement it using async/await this time.
// you should call delayedResultPromise here and get the result using async/await.
async function main() {
    let sum = await delayedResultPromise(3, 4, 6000);
    console.log(sum);
};
    
main(); // result will be shown in the console after <delayTime> seconds