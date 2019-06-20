const pathloc = "http://localhost:8080/SoloProject/api/";
const pathser = "http://35.198.82.58:8888/SoloProject/api/";

function createPromise(method, url, body) {
    return new Promise(function (resolve, reject) {

        let req = new XMLHttpRequest();

        req.open(method, url);
        req.send(body);
        req.onload = function () {
            if (req.status === 200) {
                resolve(req.response);
            } else {
                reject(Error(req.statusText));
            }
        };

        req.onerror = function () {
            reject(Error("Network Error"))
        };

    })

}


function getAllUnits() {
    createPromise("GET", pathloc + "Unit/getAllUnits").then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('unitTable');
        console.log(data[4].def);
        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (i = tableSize; i > 1; i--) {
                container.deleteRow(i - 1);
            }

        }

        for (let i = 0; i < value.length; i++) {
            let myRow = document.createElement('tr');
            container.appendChild(myRow);
            let myunitid = document.createElement('td');
            myunitid.innerHTML = data[i].cId;
            let myName = document.createElement('td');
            myName.innerHTML = data[i].name;
            let myrarity = document.createElement('td');
            myrarity.innerHTML = data[i].rarity;
            let mytype = document.createElement('td');
            mytype.innerHTML = data[i].type;
            let myalignment = document.createElement('td');
            myalignment.innerHTML = data[i].alignment;
            let myhp = document.createElement('td');
            myhp.innerHTML = data[i].hp;
            let myatk = document.createElement('td');
            myatk.innerHTML = data[i].atk;
            let mydef = document.createElement('td');
            mydef.innerHTML = data[i].def;

            myRow.appendChild(myunitid);
            myRow.appendChild(myName);
            myRow.appendChild(myrarity);
            myRow.appendChild(mytype);
            myRow.appendChild(myalignment);
            myRow.appendChild(myhp);
            myRow.appendChild(myatk);
            myRow.appendChild(mydef);
        }
    })
        .catch((error) => console.log(error.message));
    return false;
}