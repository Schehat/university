class B
{
public:
    int x;
}

class C
{
public:
    int x;
}

class A : public B,
          public C
{
};

int main(void)
{
    A a;
    a.x = 1;
}
