# CAS(无锁优化 自旋)

> Compare And Set
>
>cas(V,Expected,NewValue)
>
>CPU原语支持
>

## ABA问题
> 可以通过添加版本号可以解决改问题。
>
>如果是基础类型 无所谓
>如果是引用类型 
>


# LongAdder 与 Atomic的效率 
> LongAdder效率更高  使用的分段锁
>
> 值放到一个数组里 add操作的时候，会进行分段相加，最后再加起来，提高并发性。
> 并发量非常大时更具有优势 

