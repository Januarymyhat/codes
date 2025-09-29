import pandas as pd

# Kaggle-learn-pandas

pd.set_option('display.max_rows', 5)
print("Setup complete.")



# 	Apples	Bananas
# 0	30	    21
fruits = pd.DataFrame({
    'Apples': [30],
    'Bananas': [21]
})


#             Apples	Bananas
# 2017 Sales	35	    21
# 2018 Sales	41	    34
fruit_sales = pd.DataFrame({
        'Apples':[35,41],
        'Bananas':[21,34],
    }, 
    index = ['2017 Sales','2018 Sales']
)


# Flour     4 cups
# Milk       1 cup
# Eggs     2 large
# Spam       1 can
# Name: Dinner, dtype: object
ingredients = pd.Series(
    ['4 cups','1 cup','2 large','1 can'], 
    index = ['Flour', 'Milk', 'Eggs', 'Spam'],
    name = 'Dinner' 
)


# 读取csv文件
# 如果不写index_col=0，会创建一个名为 "Unnamed: 0" 的额外列
reviews = pd.read_csv("../input/wine-reviews/winemag-data_first150k.csv",index_col=0)

# 存储为csv文件
animals = pd.DataFrame({'Cows': [12, 20], 'Goats': [22, 19]}, index=['Year 1', 'Year 2'])
animals.to_csv("cows_and_goats.csv")










