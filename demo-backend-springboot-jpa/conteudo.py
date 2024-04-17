import os

# Lista de extensões de arquivos a serem incluídas
EXTENSIONS = ['.java', '.properties', '.sql', '.xml']
# Pastas a serem excluídas
EXCLUDED_DIRS = {'target', '.settings', '.mvn'}

def escrever_conteudos(arquivo_saida, caminho_raiz, extensoes, pastas_excluidas):
    # Abre o arquivo onde todos os conteúdos serão escritos
    with open(arquivo_saida, 'w', encoding='utf-8') as arquivo_txt:
        # Percorre a árvore de diretórios
        for raiz, dirs, arquivos in os.walk(caminho_raiz):
            # Exclui diretórios que não devem ser percorridos
            dirs[:] = [d for d in dirs if d not in pastas_excluidas and not d.startswith('.')]
            for arquivo in arquivos:
                # Verifica se o arquivo atual tem uma extensão desejada
                if any(arquivo.endswith(ext) for ext in extensoes):
                    caminho_completo = os.path.join(raiz, arquivo)
                    # Escreve o caminho do arquivo no arquivo de texto
                    arquivo_txt.write(f'--- {caminho_completo} ---\n\n')
                    # Abre e lê o conteúdo do arquivo atual
                    try:
                        with open(caminho_completo, 'r', encoding='utf-8') as conteudo:
                            arquivo_txt.writelines(conteudo)
                            # Adiciona uma nova linha para separar conteúdos de arquivos diferentes
                            arquivo_txt.write('\n\n')
                    except Exception as e:
                        print(f"Não foi possível ler o arquivo {caminho_completo}: {e}")

# Caminho da raiz do projeto Maven
caminho_projeto_maven = '.'  # Use '.' para denotar o diretório atual se o script estiver na raiz do projeto

# Arquivo de saída onde o conteúdo será concatenado
arquivo_de_saida = 'conteudo_deste_projeto.txt'

# Executa a função
escrever_conteudos(arquivo_de_saida, caminho_projeto_maven, EXTENSIONS, EXCLUDED_DIRS)
