let ctx = document.getElementById('chart').getContext('2d');

Chart.defaults.global.defaultFontFamily = 'Roboto'

var cpuAleatorio = Math.random() * (10 - 1) + 1;
var ramAleatorio = Math.random() * (10 - 1) + 1;
var Discoleatorio = Math.random() * (10 - 1) + 1;



let chart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'line',
    // The data for our dataset
    data: {
        labels: ["Processador/Cpu", "Disco", "Memória Ram", ],
        datasets: [{
            label: "Hardwares",
            backgroundColor: [
                'rgba(41, 128, 185,0.8)',
                'rgba(41, 128, 185,0.8)',
                'rgba(52, 73, 94,0.8)',
                'rgba(44, 62, 80,0.8)',
                'rgba(149, 165, 166,0.8)',
                'rgba(127, 140, 141,0.8)'
            ],
            borderColor: [
                'rgba(41, 128, 185,1.0)',
                'rgba(41, 128, 185,1.0)',
                'rgba(52, 73, 94,1.0)',
                'rgba(44, 62, 80,1.0)',
                'rgba(149, 165, 166,1.0)',
                'rgba(127, 140, 141,1.0)'
            ],
            data: [ramAleatorio, Discoleatorio, cpuAleatorio],
        }]
    },
    // Configuration options go here
    options: {
        animation : {
            duration : 2000,
            easing : 'easeOutBounce'
        },
        layout : {
            padding : {
                left : 20,
                right : 20,
                top : 20,
                bottom : 20
            }
        },
        legend : {
            display : true,
            position : 'bottom'
        },
        title : {
            display : true,
            text : 'Dashboard dos hardwares',
            fontSize : 20
        },
        tooltips : {
            enabled : true,
            intersect : true,
            backgroundColor : 'rgba(41, 128, 185,0.8)'
        },
        scales : {
            xAxes : [{
                gridLines : {
                    display : false,
                    drawBorder : false
                },
                position : 'bottom'
            }],
            yAxes : [{

                gridLines : {
                    display : false,
                    drawBorder : false
                }
            }]
        }
    }
});

const addData = () => {
    let sizeData = chart.data.datasets[0].data.length
    chart.data.datasets[0].data[sizeData] = Math.random() * 10
    chart.data.labels[sizeData] = `Novo componente detectado`
    chart.update()
}

const removeData = () => {
    chart.data.datasets[0].data.pop()
    chart.data.labels.pop()
    chart.update()
}