document.addEventListener("DOMContentLoaded", function() {
    var test = document.getElementById("test");
    test.addEventListener("click", function(event) {
        event.preventDefault();
        test.style.color = "red";
    });
});