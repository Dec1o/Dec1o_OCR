# API de OCR
Esta API em Java Spring Boot permite realizar reconhecimento óptico de caracteres (OCR) em imagens. Ela utiliza a biblioteca Tesseract para realizar a leitura do texto presente na imagem.

# Endpoints:
POST /ocr
Este endpoint permite enviar uma imagem para a API e receber o texto extraído da imagem como resposta.

# Parâmetros:
file (multipart/form-data) - A imagem a ser processada pelo OCR. Apenas arquivos com extensão .png ou .jpg são aceitos.

# Respostas:
200 OK: Retorna o texto extraído da imagem com sucesso.
400 Bad Request: Indica que a solicitação estava mal formatada ou que o formato da imagem não é suportado.
500 Internal Server Error: Indica um erro interno ao processar a imagem ou realizar o OCR.
Configuração do Tesseract
A biblioteca Tesseract é utilizada para realizar o OCR na API. Para que o Tesseract funcione corretamente, é necessário direcionar os arquivos da base de dados (tessdata) para um local específico em seu sistema. Você precisa garantir que os arquivos da base de dados estejam presentes nesse local antes de executar a API.

# Observação: 
No código fornecido, o caminho dos arquivos de dados está definido como um exemplo: "C://Users//decio.faria//JAVA_INTELLIJ//JAVA_OCR//tessdata". Certifique-se de ajustar o caminho dos arquivos da base de dados de acordo com o local onde eles estão armazenados em seu sistema.

```java
POST /ocr

Headers:
Content-Type: multipart/form-data

Body:
file: <imagem.png>
```

```java
Resposta:

200 OK
Conteúdo: "Texto extraído da imagem"
```
