document.getElementById("buscar-cep").addEventListener("click", () => {
    const cep = document.getElementById("cep").value;

    if (!cep) {
        alert("Por favor, insira um CEP válido.");
        return;
    }

    const requestPayload = { cep: cep };

    fetch("http://localhost:8080/api/endereco/busca-cep", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(requestPayload)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Erro ao buscar o CEP.");
        }
        return response.json();
    })
    .then(data => {
        document.getElementById("estado").value = data.estado || "";
        document.getElementById("cidade").value = data.cidade || "";
        document.getElementById("bairro").value = data.bairro || "";
        document.getElementById("logradouro").value = data.logradouro || "";
    })
    .catch(error => {
        console.error(error);
        alert("Não foi possível buscar o CEP. Verifique o CEP e tente novamente.");
    });
});

document.getElementById("form").addEventListener("submit", (event) => {
    event.preventDefault();
    const dados = {
        nome: document.getElementById("nome").value,
        idade: document.getElementById("idade").value,
        cep: document.getElementById("cep").value,
        estado: document.getElementById("estado").value,
        cidade: document.getElementById("cidade").value,
        bairro: document.getElementById("bairro").value,
        logradouro: document.getElementById("logradouro").value,
        telefone: document.getElementById("telefone").value,
        score: document.getElementById("score").value,
    };

    fetch("http://localhost:8080/api/pessoa/cadastrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(dados)
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(err => {
                throw new Error(err || "Erro ao cadastrar a pessoa.");
            });
        }
        return response.text();
    })
    .then(data => {
        alert(data);
        console.log("Resposta do backend:", data);
        window.location.href = "../listar-pessoas.html";
    })
    .catch(error => {
        console.error(error);
        alert("Não foi possível realizar o cadastro. Motivo: " + error.message);
    });
});