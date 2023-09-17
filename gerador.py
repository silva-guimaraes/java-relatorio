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

    def row(self):
        return [self.nome, self.estado, self.idade, self.formacao,
                self.linguas_programacao, self.certificados, self.empregos]


nomes = []
with open('nomes.txt') as file:
    nomes = [line.rstrip() for line in file]

estados = []
with open('estados.txt') as file:
    estados = [line.rstrip() for line in file]

formacoes = [
        'ensino fundamental',
        'ensino médio',
        'ensino médio',
        'ensino médio',
        'curso proficionalizante',
        'curso proficionalizante',
        'curso proficionalizante',
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

candidatos = []
for nome in nomes:
    estado = estados[random.randint(0, len(estados)-1)]
    idade = random.randint(17, 45)
    formacao = formacoes[random.randint(0, len(formacoes)-1)]
    linguagens_programacao = random.randint(2, 12)
    certificados = random.randint(0, 6)
    empregos = random.randint(0, 10)
    candidatos.append(candidato(nome,
                                estado,
                                idade,
                                formacao,
                                linguagens_programacao,
                                certificados,
                                empregos,
                                ))

with open('dataset.csv', 'w', newline='') as csvfile:
    spamwriter = csv.writer(csvfile, delimiter=',',
                            quotechar='|', quoting=csv.QUOTE_MINIMAL)
    rows = ['nome', 'estado', 'idade', 'formacao', 'linguas_programacao',
            'certificados', 'empregos']
    spamwriter.writerow(rows)
    for candidato in candidatos:
        spamwriter.writerow(candidato.row())
