# Execução do projeto local

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados:
- [Docker](https://www.docker.com/) - Versão mais recente recomendada
- [JDK 21](https://openjdk.org/projects/jdk/21/) - Opcional para testes locais

## Construindo a imagem Docker
```bash
docker build -t java-app .
```

## Executando a imagem Docker criada
```bash
docker run --rm java-app
```
