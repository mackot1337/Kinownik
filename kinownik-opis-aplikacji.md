# Kinownik - opis aplikacji

## 1. Wstęp

Na zaliczenie z aplikacji mobilnych przygotowuję aplikację na system Android o nazwie Kinownik. Służy do zapisywania filmów i seriali: tego, co chcę obejrzeć, i tego, co już obejrzałem. Oferuje łączenie z darmową filmową bazą danych do wyszukiwania.
## 2. Cel projektu

Celem jest aplikacja, z której da się korzystać na co dzień. Po otwarciu mam widzieć, co mam zapisane na później, i móc szybko dostać pomysł na wieczór. Po seansie chcę dopisać datę i wystawić ocenę.

## 3. Założenia

Projekt robię sam, na telefon z Androidem, z interfejsem po polsku. Zakładam jednego użytkownika, bez zakładania konta i bez własnego serwera.

Lista do obejrzenia, biblioteka, oceny, seanse, zdjęcia i miejsca są zapisane lokalnie. Internet jest potrzebny przy podpowiedziach na wieczór i przy wyszukiwaniu tytułu w bazie. Po dodaniu tytułu jego nazwa, opis i plakat zostają u mnie, więc bibliotekę da się otworzyć także bez sieci.

## 4. Zakres

W aplikacji jest sześć ekranów: do obejrzenia, na wieczór, biblioteka, szukanie w bazie, tytuł i nowy seans.

Na ekranie tytułu da się odtworzyć zwiastun z TMDb + youtube w aplikacji i ścieżkę dźwiękową prawdopodobnie spotify api po artyście. Propozycje na wieczór pojawiają się z animacją.

Apliakcja obsługuje geolokalizację

## 5. Funkcjonalności

Po uruchomieniu widzę ekran „Do obejrzenia”. Karta „Na wieczór” prowadzi przez cztery pytania do sześciu propozycji. Na liście pod spodem każdy tytuł ma typ, film albo serial. Plus otwiera szukanie w bazie, więc polecony film dopisuję bez przełączania zakładki.

„Na wieczór” zaczyna się od „Jaki gatunek?”. Wybrany gatunek jest zaznaczony. „Dalej” przechodzi do następnego pytania, strzałka wraca. Na wyniku widać cztery skróty wyboru i sześć tytułów z rokiem. „Dobierz ponownie” losuje inną szóstkę. Stuknięcie tytułu otwiera jego ekran.

Biblioteka grupuje seanse miesiącami. W marcu 2026 Dune: Part Two jest obejrzane, z datą i oceną 9/10, a The Bear jest w trakcie, z odcinkami S02E04–E06. W styczniu ten sam film wraca z inną datą i z tą samą oceną.

Szukanie w bazie, po plusie, pokazuje trafienia z internetu. Dune: Part Two i Dune mają plakietkę „Obejrzane”, bo już są w bibliotece. Dune: Prophecy ma szarą plakietkę „Nieobejrzane”. Wejście w wynik otwiera ten sam ekran tytułu.

Na tytule filmu widać czas trwania i ocenę widzów, moją ocenę 9/10, opis oraz dwa seanse, z czego jeden z miejscem Kraków. Na dole są „Do obejrzenia” i „Obejrzane”. Na tytule serialu zamiast czasu są sezony, ocena jest jeszcze pusta, a seans ma odcinki i miejsce. Tam statusów jest trzy i zaznaczone jest „W trakcie”. „Dopisz seans” otwiera formularz. Zwiastun i ścieżka dźwiękowa służą do odtworzenia materiału wbudowanego w aplikację.

Nowy seans pyta o datę, co obejrzane, zdjęcie i miejsce. Dla filmu wpisane jest „Cały film”, zdjęcie to bilet albo kadr, a miejsce, na przykład Kraków, bierze się z telefonu. Przy serialu w tym samym polu wpisuję odcinki. „Zapisz seans” wraca do tytułu.

Po zamknięciu aplikacji listy, oceny, seanse, zdjęcia i miejsca zostają zapisane.
