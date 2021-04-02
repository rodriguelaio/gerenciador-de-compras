function inserirLinha() {
    let tabelaDeItens = document.getElementById("itens");
    let linha = tabelaDeItens.insertRow(-1);
    for (let index = 0; index < tabelaDeItens.rows[0].cells.length; index++) {
        let novaLinha = linha.insertCell(index);
        // console.log(tabelaDeItens.rows[1].cells.item(index));
        // tabelaDeItens.rows[1].cells.item(index).id;
        let chaveDoId = tabelaDeItens.rows[1].cells.item(index).id.substring(0, tabelaDeItens.rows[1].cells.item(index).id.indexOf("_"));
        let serial = tabelaDeItens.rows[1].cells.item(index).id.substring(tabelaDeItens.rows[1].cells.item(index).id.indexOf("_") + 1);
        console.log(tabelaDeItens.rows[1].cells.item(index).id);
        console.log(chaveDoId + tabelaDeItens.rows.length);
        // console.log(tabelaDeItens.rows[1].cells.item(index).innerHTML.replace(tabelaDeItens.rows[1].cells.item(index).id, chaveDoId + tabelaDeItens.rows.length));
        // novaLinha.innerHTML = tabelaDeItens.rows[1].cells.item(index).innerHTML.replace(tabelaDeItens.rows[1].cells.item(index).id, chaveDoId + tabelaDeItens.rows.length);
        novaLinha.innerHTML = tabelaDeItens.rows[1].cells.item(index).innerHTML;
        // console.log(novaLinha.innerHTML);
    }
}

function deletarLinha(row) {
    let indiceDaLinha = row.parentNode.parentNode.rowIndex;
    let tabelaDeItens = document.getElementById("itens");
    if (tabelaDeItens.rows.length > 2) {
        document.getElementById("itens").deleteRow(indiceDaLinha);
    }
}

function calcularTotalBruto(row) {
    multiplicarDoisValoresEAtribuirResultadoEmUmElementoPeloId(row, "quantidade_", "valorUnitarioBruto_", "valorTotalBruto_");
}

function calcularTotalLiquido(row) {
    multiplicarDoisValoresEAtribuirResultadoEmUmElementoPeloId(row, "quantidade_", "valorUnitarioLiquido_", "valorTotalLiquido_");
}

function calcularPercentualDeDesconto(row) {
    calcularPercentualDeDoisValoresEAtribuirResultadoEmUmElementoPeloId(row, "valorUnitarioBruto_", "valorDesconto_", "percentualDesconto_");
}

function calcularValorUnitarioLiquido(row) {
    substrairDoisValoresEAtribuirResultadoEmUmElementoPeloId(row, "valorUnitarioBruto_", "valorDesconto_", "valorUnitarioLiquido_");
}

function multiplicarDoisValoresEAtribuirResultadoEmUmElementoPeloId(row, chaveDoIdDoCampoA, chaveDoIdDoCampoB, chaveDoIdDoCampoDeResultado) {
    let serial = extrairSerialDoIdDaLinhaDaTabela(row);
    let valores = extrairDoisValoresDaTabelaPeloId(serial, chaveDoIdDoCampoA, chaveDoIdDoCampoB);
    if (valores[0] && valores[1]) {
        document.getElementById(chaveDoIdDoCampoDeResultado + serial).value = valores[0] * valores[1];
    }
}

function calcularPercentualDeDoisValoresEAtribuirResultadoEmUmElementoPeloId(row, chaveDoIdDoCampoA, chaveDoIdDoCampoB, chaveDoIdDoCampoDeResultado) {
    let serial = extrairSerialDoIdDaLinhaDaTabela(row);
    let valores = extrairDoisValoresDaTabelaPeloId(serial, chaveDoIdDoCampoA, chaveDoIdDoCampoB);
    if (valores[0] && valores[1]) {
        document.getElementById(chaveDoIdDoCampoDeResultado + serial).value = 100 - ((valores[0] - valores[1]) / valores[0] * 100);
    }
}

function substrairDoisValoresEAtribuirResultadoEmUmElementoPeloId(row, chaveDoIdDoCampoA, chaveDoIdDoCampoB, chaveDoIdDoCampoDeResultado) {
    let serial = extrairSerialDoIdDaLinhaDaTabela(row);
    let valores = extrairDoisValoresDaTabelaPeloId(serial, chaveDoIdDoCampoA, chaveDoIdDoCampoB);
    if (valores[0] && valores[1]) {
        document.getElementById(chaveDoIdDoCampoDeResultado + serial).value = valores[0] - valores[1];
    }
}

function extrairSerialDoIdDaLinhaDaTabela(row) {
    return row.id.substring(row.id.indexOf("_") + 1);
}

function extrairDoisValoresDaTabelaPeloId(serial, chaveDoIdDoCampoA, chaveDoIdDoCampoB) {
    return [document.getElementById(chaveDoIdDoCampoA + serial).value, document.getElementById(chaveDoIdDoCampoB + serial).value];
}