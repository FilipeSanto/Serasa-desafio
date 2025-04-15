document.getElementById("buscar-cep").addEventListener("click", () => {
    const cep = document.getElementById("cep").value;

    if (!cep) {
        alert("Por favor, insira um CEP válido.");
        return;
    }

    // Criar o payload correspondente ao CepRequestDTO
    const requestPayload = { cep: cep };

    fetch("http://localhost:8080/pessoa/busca-cep", {
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
        // Preenche os campos do formulário com os dados retornados
        document.getElementById("estado").value = data.estado || "";
        document.getElementById("cidade").value = data.cidade || "";
        document.getElementById("bairro").value = data.bairro || "";
        document.getElementById("logradouro").value = data.logradouro || "";
    })
    .catch(error => {
        console.error(error);
        alert("Não foi possível buscar o CEP.");
    });
});

// Função para submissão do formulário
document.getElementById("form").addEventListener("submit", (event) => {
    event.preventDefault(); // Previne envio padrão do formulário
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

    console.log("Dados cadastrados:", dados);
    alert("Cadastro realizado com sucesso!");
});