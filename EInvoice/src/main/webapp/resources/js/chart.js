 window.onload = function () {
    var chart = new CanvasJS.Chart("chartContainer",
    {
      title:{
        text: "Manager Invoice"
      },
      data: [
      {
        type: "bar",
        dataPoints: [
        { y: 198, label: "Jan"},
        { y: 201, label: "Fed"},
        { y: 202, label: "Mar"},
        { y: 236, label: "Apr"},
		{ y: 198, label: "May"},
        { y: 201, label: "Jun"},
        { y: 202, label: "Jul"},
        { y: 236, label: "Agu"},
       
        ]
      },
      {
        type: "bar",
        dataPoints: [
      	{ y: 198, label: "Jan"},
        { y: 201, label: "Fed"},
        { y: 202, label: "Mar"},
        { y: 236, label: "Apr"},
		{ y: 198, label: "May"},
        { y: 201, label: "Jun"},
        { y: 202, label: "Jul"},
        { y: 236, label: "Agu"},
        ]
      },
      {
        type: "bar",
        dataPoints: [
        { y: 198, label: "Jan"},
        { y: 201, label: "Fed"},
        { y: 202, label: "Mar"},
        { y: 236, label: "Apr"},
		{ y: 198, label: "May"},
        { y: 201, label: "Jun"},
        { y: 202, label: "Jul"},
        { y: 236, label: "Agu"},
        ]
      }
      ]
    });
chart.render();
 }