const banner = document.querySelector('.banner');

banner.addEventListener('click', () => {
    const headline = document.querySelector('.headline');
    if (headline.textContent === 'Welcome Message') {
        headline.textContent = 'Have a Good Time!';
    } else {
        headline.textContent = 'Welcome Message';
    }
});

const button = document.querySelector('.button');
button.addEventListener('click', () => {
    const hiddenRow = document.querySelector('.hiddenRow');
    if (hiddenRow.style.display === 'none') {
        hiddenRow.style.display = 'grid';
        button.textContent = 'Hide';
    } else {
        hiddenRow.style.display = 'none';
        button.textContent = 'Call to Action';
    }
});
