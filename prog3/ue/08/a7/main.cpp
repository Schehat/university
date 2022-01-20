#include <iostream>

using namespace std;

class MyInt
{
public:
    MyInt(int i) : i(i)
    {
        cout << "MyInt(" << i << ") constructed." << endl;
    }
    MyInt(const MyInt &m) : i(m.i)
    {
        cout << "MyInt(" << i << ") constructed." << endl;
    }
    ~MyInt()
    {
        cout << "MyInt(" << i << ") destructed." << endl;
    }

private:
    int i;
};
void foo(MyInt m)
{
    cout << "foo invoked." << endl;
}
MyInt global{1};
int main(void)
{
    MyInt *heap;
    cout << "Right before MyInt local" << endl;
    MyInt local{2};
    heap = new MyInt{3};
    foo(local);
    foo(MyInt{4});
    // foo(new MyInt{5}); // Compiler error - why?
    cout << "Cleaning up now..." << endl;
    delete heap;
    return 0;
}