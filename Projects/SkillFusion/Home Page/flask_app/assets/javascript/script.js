document.querySelectorAll('.btn_main').forEach(button => {
    button.addEventListener('mouseenter', () => {
        button.style.background = "#ff7846";
        button.style.color = "white";
    });

    button.addEventListener('mouseleave', () => {
        button.style.background = "transparent";
        button.style.color = "#ff7846";
    });
});

