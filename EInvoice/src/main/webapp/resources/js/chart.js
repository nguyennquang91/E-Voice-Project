
window.onload = function () {
	 var dps = [[]];
    var chart = new CanvasJS.Chart("chartContainer",
    {
      title:{
        text: "Manager Invoice"
      },
      data: [{
		type: "bar",
		dataPoints: dps[0]
	}]
    });
    
    
chart.render();
 }
 
 