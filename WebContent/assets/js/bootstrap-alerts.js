window.setTimeout(function() {
    //$(".custom-alert").alert('close'); <--- Do not use this
  
    $(".custom-alert").slideUp(500, function() {
        $(this).remove();
    });
}, 3000);

$("div.alert").on("click", "button.close", function() {
    $(this).parent().animate({opacity: 0}, 500).hide('slow');
});