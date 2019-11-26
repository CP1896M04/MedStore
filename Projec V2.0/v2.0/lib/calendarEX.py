# Create an HTML formatted calendar
import lib.calen

hc = lib.calen.HTMLCalendar(lib.calen.THURSDAY)
str = hc.formatmonth(2025, 1)
print:str