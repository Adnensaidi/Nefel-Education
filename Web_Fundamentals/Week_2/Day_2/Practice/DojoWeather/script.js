const tempUnit = document.getElementById('tempUnit');

tempUnit.addEventListener('change', function() {
    const temperatures = document.querySelectorAll('.temperature_one, .temperature_two');
    
    temperatures.forEach(temp => {
        let value = parseFloat(temp.textContent.replace('°', ''));
        
        if (this.value === 'fahrenheit') {
            value = (value * 9/5) + 32;
        } else {
            value = (value - 32) * 5/9;
        }
        
        temp.textContent = Math.round(value) + '°';
    });
});


function removeFooter(element) {
    document.querySelector(element).remove() ;
}