btn.onclick = function () {
  if (input.value === "Введите текст...") {
    alert("Введите текст!");
    return;
  }
  const options = {
    method: "POST",
    headers: {
      "content-type": "application/json",
      "X-RapidAPI-Key": "87dc11ece0msh0f19268a79aac3dp1a40fejsna8ec5ca21381",
      "X-RapidAPI-Host": "ai-translation-apis.p.rapidapi.com",
    },
    body: `{"fromLan":"ru","toLan":"en","text":"${input.value}"}`,
  };

  fetch("https://ai-translation-apis.p.rapidapi.com/", options)
    .then((response) => response.json())
    .then((response) => {
      console.log(response);
      document.getElementById("answer").innerHTML = response.data.translated;
    })
    .catch((err) => console.error(err));
};
