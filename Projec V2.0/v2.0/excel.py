import pandas as pd
from pandas import ExcelFile
path = 'D:\Git\Python\Demo.xlsx'
sheet=pd.read_excel(path)
print(sheet)

