const textToEncrypt = document.getElementById("noEncrypt")
const textEncrypt = document.getElementById("encrypt")

// La letra "e" es convertida para "enter"
// La letra "i" es convertida para "imes"
// La letra "a" es convertida para "ai"
// La letra "o" es convertida para "ober"
// La letra "u" es convertida para "ufat"

let matrixCode = [["e", "enter"], ["i", "imes"], ["a", "ai"], ["o", "ober"], ["u", "ufat"]]

const encrypt = (stringEncrypt) => {
    // let text = textToEncrypt.value
    // let textEncrypt = ""
    // for (let i = 0; i < text.length; i++) {
    //     for (let j = 0; j < matrixCode.length; j++) {
    //         if (text[i] === matrixCode[j][0]) {
    //             textEncrypt += matrixCode[j][1]
    //         }
    //     }
    // }
    // return textEncrypt
    stringEncrypt = stringEncrypt.toLowerCase();
    for(let i = 0; i < matrixCode.length; i++){
        if(stringEncrypt.includes(matrixCode[i][0])){
            stringEncrypt = stringEncrypt.replaceAll(matrixCode[i][0], matrixCode[i][1])
        }
    }
    return stringEncrypt
}

const decrypt = (stringDecrypt) => {
    stringDecrypt = stringDecrypt.toLowerCase();
    for(let i = 0; i < matrixCode.length; i++){
        if(stringDecrypt.includes(matrixCode[i][1])){
            stringDecrypt = stringDecrypt.replaceAll(matrixCode[i][1], matrixCode[i][0])
        }
    }
    return stringDecrypt
}

const btnEncrypt = () => {
    const noEncrypt = encrypt(textToEncrypt.value)
    textEncrypt.value = noEncrypt;
}

const btnDecrypt = () => {
    const encrypt = decrypt(textEncrypt.value)
    textToEncrypt.value = encrypt;
}
