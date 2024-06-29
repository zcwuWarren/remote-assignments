function avg(data) {
    let avg = data
    .products
    .reduce((sum, item) => sum + item.price, 0)/data.size;
    return avg;
}

console.log(
    avg({
        size: 3, 
        products: [
            {
                name: 'Product 1', 
                price: 100,
            },
            {
                name: 'Product 2', 
                price: 700,
            }, 
            {
                name: 'Product 3', 
                price: 250,
            },
        ],
    })
);