$(function () {
    $(".widget input[type=submit], .widget a, .widget button").button();
    $("button, input, a").click(function (event) {
        event.preventDefault();
    });
});

$(function () {
    $("#datepicker").datepicker();
});