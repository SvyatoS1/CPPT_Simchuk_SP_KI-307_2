from scanner import Scanner
from copier import Copier

if __name__ == "__main__":
    scanner = Scanner("OfficeJet Pro 8710", is_color=True)
    copier = Copier("Xerox WorkCentre 6515", is_color=True, is_duplex=True)

    scanner.turn_on()
    scanner.scan("Document 1")
    print(f"Scanner DPI: {scanner.dpi()}")
    scanner.turn_off()

    copier.turn_on()
    copier.copy("Document 2")
    print(f"Copier DPI: {copier.dpi()}")
    print(f"Copier isDuplex: {copier.is_duplex()}")
    copier.turn_off()

    source_files = ["file1.txt", "file2.txt"]
    destination_file = "combined_file.txt"
    copier.turn_on()
    copier.copy_content_from_files(source_files, destination_file)
    copier.turn_off()
