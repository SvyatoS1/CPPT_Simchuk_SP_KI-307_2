from scanner import Scanner


class Copier(Scanner):
    def __init__(self, model, is_color, is_duplex):
        super().__init__(model, is_color)
        self.is_duplex_mode = is_duplex

    def copy(self, document):
        if self.is_turned_on:
            print(f"{self.model} copying {document} in {'color' if self.is_color else 'black and white'}.")
            if self.is_duplex_mode:
                print("Duplex copying is enabled.")
            else:
                print("Single-sided copying is used.")
        else:
            print(f"{self.model} is turned off. Cannot copy.")

    def is_duplex(self):
        return self.is_duplex_mode

    def copy_content_from_files(self, source_files, destination_file):
        if self.is_turned_on:
            with open(destination_file, 'w') as dest:
                for source_file in source_files:
                    with open(source_file, 'r') as source:
                        dest.write(source.read())
                print(f"{self.model} copied content from multiple files to {destination_file}.")
        else:
            print(f"{self.model} is turned off. Cannot copy content.")
