const userId = sessionStorage.getItem('userLogin');

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

function displayUsers() {

    createPromise("GET", pathloc + "User/findAUserId/" + userId).then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('userTable');

        document.getElementById('ownName').innerText = "Welcome " + data.username + " see the units in your storage on this page";
    })
}
function getAllTeams() {
    createPromise("GET", pathloc + "Team/findATeamUser/" + userId).then(value => {
        let data = JSON.parse(value);
        const container = document.getElementById('unitTable');

        if (container.rows.length > 1) {

            let tableSize = container.rows.length;
            for (i = tableSize; i > 1; i--) {
                container.deleteRow(i - 1);
            }
        }

        console.log(data[1]);

        for (let i = 0; i < value.length; i++) {
            let tId = data[i];
            let myRow = document.createElement('tr');
            container.appendChild(myRow);
            createPromise("GET", pathloc + "Team/getTeamUnits/" + tId).then(result => {
                let unit = JSON.parse(result);
                console.log(unit[1]);

                for (let i = 0; i < result.length; i++) {
                    let cId = unit[i];
                    createPromise("GET", pathloc + "Unit/getUnitId/" + cId).then(result1 => {
                        let unit1 = JSON.parse(result);

                        for (let i = 0; i < value.length; i++) {

                            let myLeader = document.createElement('th');
                            myunitid.innerHTML = unit1[i].name;
                            let myLeader = document.createElement('th');
                            myunitid.innerHTML = unit1[i].name;
                            let myLeader = document.createElement('th');
                            myunitid.innerHTML = unit1[i].name;
                            let myLeader = document.createElement('th');
                            myunitid.innerHTML = unit1[i].name;
                            let myLeader = document.createElement('th');
                            myunitid.innerHTML = unit1[i].name;
                            let myLeader = document.createElement('th');
                            myunitid.innerHTML = unit1[i].name;

                            myRow.appendChild(myName);
                            myRow.appendChild(myLeader);
                            myRow.appendChild(myUnit1);
                            myRow.appendChild(myUnit2);
                            myRow.appendChild(myUnit3);
                            myRow.appendChild(myUnit4);
                            myRow.appendChild(myUnit5);


                        }
                    })
                }
            })
        }
    })
}

function getAllUnits() {
    createPromise("GET", pathloc + "Storage/getUserStore/" + userId).then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('unitTable');
        console.log(data[4]);
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
            if (data[i].rarity == 1) {
                myrarity.innerHTML = "N";
            } else if (data[i].rarity == 2) {
                myrarity.innerHTML = "R";
            } else if (data[i].rarity == 3) {
                myrarity.innerHTML = "SR";
            } else if (data[i].rarity == 4) {
                myrarity.innerHTML = "SSR";
            } else if (data[i].rarity == 5) {
                myrarity.innerHTML = "UR";
            } else if (data[i].rarity == 6) {
                myrarity.innerHTML = "TUR";
            } else if (data[i].rarity == 7) {
                myrarity.innerHTML = "LR";
            } else {
                myrarity.innerHTML = "EZA";
            }

            let mytype = document.createElement('td');

            if (data[i].type == 1) {
                mytype.innerHTML = "STR";
            } else if (data[i].type == 2) {
                mytype.innerHTML = "PHY";
            } else if (data[i].type == 3) {
                mytype.innerHTML = "INT";
            } else if (data[i].type == 4) {
                mytype.innerHTML = "TEQ";
            } else {
                mytype.innerHTML = "AGL";
            }

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



function loadUpdate() {
    window.location.href = 'update.html';
}

function loadDetails() {

    createPromise("GET", pathloc + "User/findAUserId/" + userId).then(value => {

        let data = JSON.parse(value);
        const container = document.getElementById('userTable');

        document.getElementById('upuser').value = data.username;
        document.getElementById('upemail').value = data.email;
        document.getElementById('conupemail').value = data.email;
    })
}