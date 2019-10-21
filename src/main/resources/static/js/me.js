/*搜索框的显示与隐藏*/
var content = [
  { title: 'Andorra' },
  { title: 'United Arab Emirates' },
  { title: 'Afghanistan' },
  { title: 'Antigua' },
  { title: 'Anguilla' },
  { title: 'Albania' },
  { title: 'Armenia' },
  { title: 'Netherlands Antilles' },
  { title: 'Angola' },
  { title: 'Argentina' },
  { title: 'American Samoa' },
  { title: 'Austria' },
  { title: 'Australia' },
  { title: 'Aruba' },
  { title: 'Aland Islands' },
  { title: 'Azerbaijan' },
  { title: 'Bosnia' },
  { title: 'Barbados' },
  { title: 'Bangladesh' },
  { title: 'Belgium' },
  { title: 'Burkina Faso' },
  { title: 'Bulgaria' },
  { title: 'Bahrain' },
  { title: 'Burundi' }
  // etc
];

function openSearch() {
  var divDisp = document.getElementById("searchArea").style.display;
  // var docuDiso = $(document).click
  if (divDisp == "block") {
    document.getElementById("searchArea").style.display = "none";
  } else {
    document.getElementById("searchArea").style.display = "block";
  }
}
$('.ui.search')
  .search({
    source: content
  });

/*coping：顶部*/
var waypoint = new Waypoint({
  element: document.getElementById('waypoint'),
  handler: function(direction) {
    if (direction == 'down') {
      $('#toolbar').show(700);
    } else {
      $('#toolbar').hide(500);
    }
  }
});



/*$("#searchImg").on("mouseover", function(e){
  $("#searchArea").show();
  /!*$(document).one("click", function(){
    $("#searchArea").hide();
  });*!/
  e.stopPropagation();
});
window.onload=function(){
  document.onclick = function (e) {
    $("#searchArea").style.display = "none";
  }

  $("#searchImg").onclick = function (e) {
    $("#searchArea").style.display = "block";
    e = e || event;
    stopFunc(e);
  }
  $("#searchImg").onclick = function (e) {
    e = e || event; stopFunc(e);
  }
}
function stopFunc(e) {
  e.stopPropagation ? e.stopPropagation() : e.cancelBubble = true;
}*/
