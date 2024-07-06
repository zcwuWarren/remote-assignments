const btn = document.querySelector('.btn');
const updateInnerText = document.querySelector('.output');
const inputBox = document.querySelector('.inputbox');

btn.addEventListener('click', function (event){
    event.preventDefault();
    const numToCompute = inputBox.value
    fetch(`http://localhost:3000/data?number=${numToCompute}`)
        .then(response => response.text())
        .then(update => updateInnerText.innerText = update)
})