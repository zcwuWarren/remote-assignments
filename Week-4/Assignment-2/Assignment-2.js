function ajax(src, callback) {
    fetch(src)
        .then(response => response.json())
        .then(data => callback(data))
}

function render(data) {
    const products = document.querySelector('.product');
    data.forEach(product => {
        const name = document.createElement('h3');
        name.textContent = `${product.name}`;
        products.appendChild(name);

        const price = document.createElement('li');
        price.textContent = `Price: ${product.price}`;
        products.appendChild(price);

        const description = document.createElement('li');
        description.textContent = `Description: ${product.description}`;
        products.appendChild(description);
    });
}

ajax(
    'https://remote-assignment.s3.ap-northeast-1.amazonaws.com/products',
    function (response) {
        render(response);
    }
)