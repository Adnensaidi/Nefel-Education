function removeButton(element){
    element.remove()
}
function plusOne(id) {
    document.querySelector(id).innerText++
}

function minusOne(id) {
    var element = document.getElementById(id)
    element.innerHTML--
}

function showAlert(){
    var value = document.getElementById('textAlert').value
    alert("The Input value is: "+value)
    document.getElementById('textAlert').value=""
}