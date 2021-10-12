const general_url = './';

function getResultGif() {
    $.ajax({
        url: general_url + 'gif/',
        method: 'GET',
        dataType: "json",
        complete: function (data) {
            let content = JSON.parse(data.responseText);
            let fig = document.createElement("figure");
            let img = document.createElement("img");
            let fc = document.createElement("figcaption");
            let tg = document.createElement("typegif");
            let cur = document.createElement("currency");

            img.src = content.data.images.original.url;
            img.alt = content.data.title;
            fc.textContent = content.data.title;
            tg.textContent = content.typegif+"\n";
            cur.textContent = content.currency+"\n";

            fig.appendChild(img);
            fig.appendChild(fc);
            fig.appendChild(tg);
            fig.appendChild(cur);

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