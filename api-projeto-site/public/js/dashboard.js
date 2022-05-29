let ctxCpu = document.getElementById('chart_cpu').getContext('2d');
let ctxRam = document.getElementById('chart_ram').getContext('2d');
let ctxDisco = document.getElementById('chart_disco').getContext('2d');

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
            label: "",
            backgroundColor: [
                'rgb(194, 2, 2)'
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
        maintainAspectRatio: false,
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
            display: false,
            position: 'bottom'
        },
        title: {
            display: false,
            text: 'Processador/Cpu',
            fontSize: 20
        },
        tooltips: {
            enabled: true,
            intersect: true,
            backgroundColor: 'rgba(41, 128, 185,0.8)'
        },
        scales: {
            y: {
                stacked: true,
                grid: {
                    display: true,
                    color: "rgba(255,99,132,0.2)"
                }
            },
            x: {
                grid: {
                    display: false
                }
            }
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
            label: "",
            backgroundColor: [
                'rgb(226, 226, 3)'
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
        maintainAspectRatio: false,
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
            display: false,
            position: 'bottom'
        },
        title: {
            display: false,
            text: 'Disco',
            fontSize: 20
        },
        tooltips: {
            enabled: true,
            intersect: true,
            backgroundColor: 'rgba(41, 128, 185,0.8)'
        },
        scales: {
            y: {
                stacked: true,
                grid: {
                    display: true,
                    color: "rgba(255,99,132,0.2)"
                }
            },
            x: {
                grid: {
                    display: false
                }
            }
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
            label: "",
            backgroundColor: [
                'rgb(3, 119, 3)'
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
        maintainAspectRatio: false,
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
            display: false,
            position: 'bottom'
        },
        title: {
            display: false,
            text: 'Memória Ram',
            fontSize: 20
        },
        tooltips: {
            enabled: true,
            intersect: true,
            backgroundColor: 'rgba(41, 128, 185,0.8)'
        },
        scales: {
            y: {
                stacked: true,
                grid: {
                    display: true,
                    color: "rgba(255,99,132,0.2)"
                }
            },
            x: {
                grid: {
                    display: false
                }
            }
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