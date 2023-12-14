class Scanner:
    def __init__(self, model, is_color):
        self.model = model
        self.is_color = is_color
        self.is_turned_on = False

    def scan(self, document):
        if self.is_turned_on:
            print(f"{self.model} scanning {document} in {'color' if self.is_color else 'black and white'}.")
        else:
            print(f"{self.model} is turned off. Cannot scan.")

    def is_duplex(self):
        return False

    def dpi(self):
        return 300 if self.is_color else 600

    def turn_on(self):
        self.is_turned_on = True
        print(f"{self.model} is turned on.")

    def turn_off(self):
        self.is_turned_on = False
        print(f"{self.model} is turned off.")
