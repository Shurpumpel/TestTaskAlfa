const general_url = './';

function getResultGif() {

    let select = document.querySelector("#select-code").selectedOptions[0].value;
    $.ajax({
        url: general_url + 'gif/' + select,
        method: 'GET',
        dataType: "json",
        complete: function (data) {
            let content = JSON.parse(data.responseText);
            let fig = document.createElement("figure");
            let img = document.createElement("img");
            let fc = document.createElement("figcaption");
            let tg = document.createElement("typegif");
            let coeff = document.createElement("coefficient");

            img.src = content.urlGif;
            img.alt = content.searchTag;
            fc.textContent = content.searchTag;
            tg.textContent = content.title+"\n";
            coeff.textContent = content.coefficient+"\n";

            fig.appendChild(img);
            fig.appendChild(fc);
            fig.appendChild(tg);
            fig.appendChild(coeff);

            let out = document.querySelector("#out");
            out.innerHTML = "";
            out.insertAdjacentElement("afterbegin", fig);
        }
    })
}

function getCurrencies() {
    $.ajax({
        url: general_url + 'currencies/',
        method: 'GET',
        complete: function (data) {
            let content = JSON.parse(data.responseText);
            let select = document.querySelector("#select-code");
            select.innerHTML = '';
            for (let key in content) {
                let option = document.createElement("option");
                option.value = key;
                option.text = content[key] + " (" + key + ")";
                select.insertAdjacentElement("beforeend", option);
            }
        }
    })
}