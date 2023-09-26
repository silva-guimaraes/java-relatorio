import random
import csv


class candidato():

    def __init__(self, nome, estado, idade, formacao, linguas_programacao,
                 certificados, empregos):
        self.nome = nome
        self.estado = estado
        self.idade = idade
        self.formacao = formacao
        self.linguas_programacao = linguas_programacao
        self.certificados = certificados
        self.empregos = empregos

    def __repr__(self):
        return f'(nome: {self.nome}, estado: {self.estado}, \
idade {self.idade}, formação: {self.formacao}, N# de linguas: \
{self.linguas_programacao}, certificados: {self.certificados}, \
N# de empregos prévios: {self.empregos})'

    def row(self, id):
        return [id, self.nome, self.estado, self.idade, self.formacao,
                self.linguas_programacao, self.certificados, self.empregos]


prenomes = []
with open('nomes.txt') as file:
    prenomes = [line.rstrip() for line in file]

sobrenomes = []
with open('sobrenomes.txt') as file:
    sobrenomes = [line.rstrip() for line in file]

estados = []
with open('estados.txt') as file:
    estados = [line.rstrip() for line in file]

formacoes = [
        'ensino fundamental',
        'ensino médio',
        'ensino médio',
        'ensino médio',
        'curso profissionalizante',
        'curso profissionalizante',
        'curso profissionalizante',
        'autodidata',
        'autodidata',
        'autodidata',
        'ensino superior',
        'ensino superior',
        'ensino superior',
        'ensino superior',
        'doutorado',
        'mestrado',
        ]

nomes = []
for i in range(200):
    prenome = prenomes[random.randint(0, len(prenomes)-1)]
    sobrenome = sobrenomes[random.randint(0, len(sobrenomes)-1)]

    nomes.append(prenome + ' ' + sobrenome)


candidatos = []
for nome in nomes:

    estado = estados[random.randint(0, len(estados)-1)]
    idade = random.randint(17, 45)
    formacao = formacoes[random.randint(0, len(formacoes)-1)]
    linguagens_programacao = random.randint(2, 12)
    certificados = random.randint(0, 6)
    empregos = random.randint(0, 10)

    candidatos.append(candidato(
        nome, estado, idade, formacao,
        linguagens_programacao, certificados,
        empregos,
        ))

with open('dataset.csv', 'w', newline='') as csvfile:
    spamwriter = csv.writer(csvfile, delimiter=',',
                            quotechar='|', quoting=csv.QUOTE_MINIMAL)
    rows = ['id', 'nome', 'estado', 'idade', 'formacao', 'linguas_programacao',
            'certificados', 'empregos']
    spamwriter.writerow(rows)
    for i, candidato in enumerate(candidatos):
        spamwriter.writerow(candidato.row(i+1))

print('dataset.csv')
