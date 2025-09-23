import numpy as np
import datetime

# 1. 数据类型
# 字符        对应类型                备注
# b	        boolean	                'b1'
# i         signed integer	        'i1', 'i2', 'i4', 'i8'
# u	        unsigned integer	    'u1', 'u2' ,'u4' ,'u8'
# f	        floating-point	        'f2', 'f4', 'f8'
# c	        complex floating-point
# m	        timedelta64	            表示两个时间之间的间隔
# M	        datetime64	            日期时间类型
# O	        object
# S	        (byte-)string	        S3表示长度为3的字符串
# U	        Unicode	                Unicode 字符串
# V	        void
a = np.dtype('b1')
print(a.type)  # <class 'numpy.bool_'>
print(a.itemsize)  # 1

# 数据类型信息iinfo()
ii16 = np.iinfo(np.int16)
print(ii16.min)  # -32768
print(ii16.max)  # 32767

# 2. 时间
# datatime64是带单位的日期时间类型
# 2.1. Y M D h m s ms us ns ps
a = np.datetime64('2020-03-01')
print(a, a.dtype)  # 2020-03-01 datetime64[D]
a = np.datetime64('2020-03-08 20:00:05')
print(a, a.dtype)  # 2020-03-08T20:00:05 datetime64[s]

# 2.2. 运算
a = np.datetime64('2020-03-08') - np.datetime64('2020-03-07')
b = np.datetime64('2020-03-08') - np.datetime64('202-03-07 08:00')
c = np.datetime64('2020-03-08') - np.datetime64('2020-03-07 23:00', 'D')
print(a, a.dtype)  # 1 days timedelta64[D]
print(b, b.dtype)  # 956178240 minutes timedelta64[m]
print(c, c.dtype)  # 1 days timedelta64[D]

# 2.3. timedelta64()
a = np.timedelta64(1, 'Y')
b = np.timedelta64(6, 'M')
print(a)  # 1 year
print(b)  # 6 months

a = np.datetime64('2020-03') + np.timedelta64(20, 'D')
b = np.datetime64('2020-06-15 00:00') + np.timedelta64(12, 'h')
print(a, a.dtype)  # 2020-03-21 datetime64[D]
print(b, b.dtype)  # 2020-06-15T12:00 datetime64[m]

# 2.4. numpy.datetime64 与 datetime.datetime 相互转换
dt = datetime.datetime(year=2020, month=6, day=1, hour=20, minute=5, second=30)
dt64 = np.datetime64(dt, 's')
print(dt64, dt64.dtype)  # 2020-06-01T20:05:30 datetime64[s]

dt2 = dt64.astype(datetime.datetime)
print(dt2, type(dt2))  # 2020-06-01 20:05:30 <class 'datetime.datetime'>

# 2.5. is_busday() 快速判断一个给定的日期是否落在工作日内
# 创建一个 busdaycalendar 对象
# busdays = np.busdaycalendar(weekmask='1111100')

# 2020-07-10 星期五
a = np.is_busday('2020-07-10', weekmask=[1, 1, 1, 1, 1, 0, 0])
print(a)  # True

# busday_count()
begindates = np.datetime64('2020-07-10')
enddates = np.datetime64('2020-07-20')
a = np.busday_count(begindates, enddates)
print(a)  # 6

# 3. 数组array
# 3.1. array()和asarray()都可以将结构数据转化为 ndarray，但是array()和asarray()主要区别就是
# 当数据源是ndarray 时，array()仍然会 copy 出一个副本，占用新的内存，但不改变 dtype 时 asarray()不会。
x = np.array([[1, 1, 1],
              [1, 1, 1],
              [1, 1, 1]])
print(x, x.dtype)
# [[1 1 1]
#  [1 1 1]
#  [1 1 1]] int32

# 在ndarray中所有元素必须是同一类型，否则会自动向下转换，int->float->str
b = np.array([1, 2, 3, 4, '5'])
print(b)  # ['1' '2' '3' '4' '5']

# 3.2. fromfunction() 可从函数中创建数组
# def fromfunction(function, shape, **kwargs):   **kwargs: 传入函数中的几个参数组成字典
x = np.fromfunction(lambda i, j: i == j, (3, 3), dtype=int)
print(x)
# 当i等于j时为True，否则为False  断句为 i, j: 和 i == j
# [[ True False False]
#  [False  True False]
#  [False False  True]]

# 3.3. 填充方式
# 3.3.1. 零数组
# zeros()函数：返回给定形状和类型的零数组。
x = np.zeros([2, 3])
print(x)
# [[0. 0. 0.]
#  [0. 0. 0.]]
# 默认数据类型是浮点型（float） 输出中的"0."表示的是浮点数0

# zeros_like()函数：返回与给定数组形状和类型相同的零数组。
x = np.array([[1, 2, 3], [4, 5, 6]])
y = np.zeros_like(x)
print(y)
# [[0 0 0]
#  [0 0 0]]

# 3.3.2. 1数组
# ones()函数：返回给定形状和类型的1数组。
# ones_like()函数：返回与给定数组形状和类型相同的1数组。

# 3.3.3. 空数组
# empty()函数：返回一个空数组，数组元素为随机数。
# empty_like函数：返回与给定数组具有相同形状和类型的新数组。

# 3.3.4. 单位数组
# eye()函数：返回一个对角线上为1，其它地方为零的单位数组。
x = np.eye(2, 3)
print(x)
# [[1. 0. 0.]
#  [0. 1. 0.]]

# identity()函数：返回一个方的单位数组。
x = np.identity(4)
print(x)
# [[1. 0. 0. 0.]
#  [0. 1. 0. 0.]
#  [0. 0. 1. 0.]
#  [0. 0. 0. 1.]]

# 3.3.5. 对角数组
# diag()函数：提取对角线或构造对角数组
x = np.arange(9).reshape((3, 3))
print(x)
# [[0 1 2]
#  [3 4 5]
#  [6 7 8]]
print(np.diag(x))  # [0 4 8]
print(np.diag(x, k=1))  # [1 5]
print(np.diag(x, k=-1))  # [3 7]

v = [1, 3, 5, 7]
x = np.diag(v)
print(x)
# [[1 0 0 0]
#  [0 3 0 0]
#  [0 0 5 0]
#  [0 0 0 7]]

# 3.3.6. 常数数组
# full()函数：返回一个常数数组。
# full_like()函数：返回与给定数组具有相同形状和类型的常数数组。
x = np.full((2, 7), 7)
print(x)
# [[7 7 7 7 7 7 7]
#  [7 7 7 7 7 7 7]]

# 4. 范围
# arange()函数：返回给定间隔内的均匀间隔的值。
# linspace()函数：返回指定间隔内的等间隔数字。
# logspace()函数：返回数以对数刻度均匀分布。
# numpy.random.rand() 返回一个由[0,1)内的随机数组成的数组。
# np.around 返回四舍五入后的值，可指定精度。



