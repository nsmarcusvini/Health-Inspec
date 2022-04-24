let ctxCpu = document.getElementById('chartCpu').getContext('2d');
let ctxRam = document.getElementById('chartRam').getContext('2d');
let ctxDisco = document.getElementById('chartDisco').getContext('2d');

Chart.defaults.global.defaultFontFamily = 'Roboto'

var cpuAleatorio = Math.random() * (10 - 1) + 1;
var ramAleatorio = Math.random() * (10 - 1) + 1;
var Discoleatorio = Math.random() * (10 - 1) + 1;



let chartCpu = new Chart(ctxCpu, {
    // The type of chart we want to create
    type: 'line',
    // The data for our dataset
    data: {
        labels: ["13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00","20:00","21:00","22:00","23:00"],
        datasets: [{
            label: "Urgente",
            backgroundColor: [
                'rgb(255, 0, 0, 0.8)',
                'rgba(41, 128, 185,0.8)',
                'rgba(52, 73, 94,0.8)',
                'rgba(44, 62, 80,0.8)',
                'rgba(149, 165, 166,0.8)',
                'rgba(127, 140, 141,0.8)',
                'rgba(149, 165, 166,0.8)',
                'rgba(127, 140, 141,0.8)',
                'rgba(149, 165, 166,0.8)',
                'rgba(127, 140, 141,0.8)',
                'rgba(127, 140, 141,0.8)'
            ],
            borderColor: [
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)'
            ],
            data: [10,5,36,100,140,60,78,110,90,10,110]}]
    },
    // Configuration options go here
    options: {
        animation: {
            duration: 2000,
            easing: 'easeOutBounce'
        },
        layout: {
            padding: {
                left: 20,
                right: 20,
                top: 20,
                bottom: 20
            }
        },
        legend: {
            display: true,
            position: 'bottom'
        },
        title: {
            display: true,
            text: 'Processador/Cpu',
            fontSize: 20
        },
        tooltips: {
            enabled: true,
            intersect: true,
            backgroundColor: 'rgba(41, 128, 185,0.8)'
        },
        scales: {
            xAxes: [{
                gridLines: {
                    display: false,
                    drawBorder: false
                },
                position: 'bottom'
            }],
            yAxes: [{

                gridLines: {
                    display: false,
                    drawBorder: false
                }
            }]
        }
    }
});

let chartDisco = new Chart(ctxDisco, {
    // The type of chart we want to create
    type: 'line',
    // The data for our dataset
    data: {
        labels: ["13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00","20:00","21:00","22:00","23:00"],
        datasets: [{
            label: "Alerta",
            backgroundColor: [
                'rgba(238, 241, 26, 0.801)',
                'rgba(41, 128, 185,0.8)',
                'rgba(52, 73, 94,0.8)',
                'rgba(44, 62, 80,0.8)',
                'rgba(149, 165, 166,0.8)',
                'rgba(127, 140, 141,0.8)',
                'rgba(149, 165, 166,0.8)',
                'rgba(127, 140, 141,0.8)',
                'rgba(149, 165, 166,0.8)',
                'rgba(127, 140, 141,0.8)',
                'rgba(127, 140, 141,0.8)'
            ],
            borderColor: [
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)'
            ],
            data: [10,5,36,100,140,60,78,110,90,10,110]}]
    },
    // Configuration options go here
    options: {
        animation: {
            duration: 2000,
            easing: 'easeOutBounce'
        },
        layout: {
            padding: {
                left: 20,
                right: 20,
                top: 20,
                bottom: 20
            }
        },
        legend: {
            display: true,
            position: 'bottom'
        },
        title: {
            display: true,
            text: 'Processador/Cpu',
            fontSize: 20
        },
        tooltips: {
            enabled: true,
            intersect: true,
            backgroundColor: 'rgba(41, 128, 185,0.8)'
        },
        scales: {
            xAxes: [{
                gridLines: {
                    display: false,
                    drawBorder: false
                },
                position: 'bottom'
            }],
            yAxes: [{

                gridLines: {
                    display: false,
                    drawBorder: false
                }
            }]
        }
    }
});

let chartRam = new Chart(ctxRam, {
    // The type of chart we want to create
    type: 'line',
    // The data for our dataset
    data: {
        labels: ["13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00","20:00","21:00","22:00","23:00"],
        datasets: [{
            label: "Estável",
            backgroundColor: [
                'rgb(21, 243, 1, 0.8)',
                'rgba(41, 128, 185,0.8)',
                'rgb(21, 243, 1, 0.8)',
                'rgb(21, 243, 1, 0.8)',
                'rgb(21, 243, 1, 0.8)',
                'rgb(21, 243, 1, 0.8)',
                'rgb(21, 243, 1, 0.8)',
                'rgb(21, 243, 1, 0.8)',
                'rgba(41, 128, 185,0.8)',
                'rgba(52, 73, 94,0.8)',
                'rgba(44, 62, 80,0.8)',
                'rgba(149, 165, 166,0.8)',
                'rgba(127, 140, 141,0.8)'
            ],
            borderColor: [
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)',
                'rgb(0, 0, 0)'
            ],
            data: [100,40,25,80,110,60,38,90,40,10,110],
        }]
    },
    // Configuration options go here
    options: {
        animation: {
            duration: 2000,
            easing: 'easeOutBounce'
        },
        layout: {
            padding: {
                left: 20,
                right: 20,
                top: 20,
                bottom: 20
            }
        },
        legend: {
            display: true,
            position: 'bottom'
        },
        title: {
            display: true,
            text: 'Memória Ram',
            fontSize: 20
        },
        tooltips: {
            enabled: true,
            intersect: true,
            backgroundColor: 'rgba(41, 128, 185,0.8)'
        },
        scales: {
            xAxes: [{
                gridLines: {
                    display: false,
                    drawBorder: false
                },
                position: 'bottom'
            }],
            yAxes: [{

                gridLines: {
                    display: false,
                    drawBorder: false
                }
            }]
        }
    }
});




// const addData = () => {
//     let sizeData = chart.data.datasets[0].data.length
//     chart.data.datasets[0].data[sizeData] = Math.random() * 10
//     chart.data.labels[sizeData] = `Novo componente detectado`
//     chart.update()
// }

// const removeData = () => {
//     chart.data.datasets[0].data.pop()
//     chart.data.labels.pop()
//     chart.update()
// }