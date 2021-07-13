
  //var ctx = document.getElementById("myChart").getContext('2d');
  var ctx = $("#myChart");
  /*var myChart = new Chart(ctx, {
    type: 'doughnut',
    date: {
      labels: ["meditation", "sport", "schlaf"],
      datasets: [{
        label: 'selfcare',
        data: [meditation, sport, schlaf],
        backgroundColor: ["#111111", "#2ECC40", "#FF4136"]
      }]
    },
  });*/


  var data2 = {
      labels: ["meditation", "sport", "schlaf"],
      datasets: [{
              label: 'selfcare',
              data: [meditation, sport, schlaf],
              backgroundColor: ["#111111", "#2ECC40", "#FF4136"]
            }]
    };

    //options
    var options = {
      responsive: true,
      title: {
        display: true,
        position: "top",
        text: "Aggregation des Tages",
        fontSize: 30,
        fontColor: "#111"
      },
      legend: {
        display: true,
        position: "bottom",
        labels: {
          fontColor: "#333",
          fontSize: 25
        }
      }
    };

    //create Chart class object
    var chart2 = new Chart(ctx, {
      type: "doughnut",
      data: data2,
      options: options
    });