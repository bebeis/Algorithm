#include <iostream>
using namespace std;

class grade {
    public:
    grade() : subject(""), weight(0), mark(0) {} 
    grade(string _subject, float _weight, string _mark) {
        subject = _subject;
        weight = _weight;
        if (_mark == "A+") {
            mark = 4.5;
        }
        else if (_mark == "A0") {
            mark = 4.0;
        }
        else if (_mark == "B+") {
            mark = 3.5;
        }
        else if (_mark == "B0") {
            mark = 3.0;
        }
        else if (_mark == "C+") {
            mark = 2.5;
        }
        else if (_mark == "C0") {
            mark = 2.0;
        }
        else if (_mark == "D+") {
            mark = 1.5;
        }
        else if (_mark == "D0") {
            mark = 1.0;
        }
        else if (_mark == "P") {
            mark = 0;
            weight = 0;
        }
        else if (_mark == "F") {
            mark = 0;
        }
    }
    string subject;
    float weight;
    float mark;
};

int main(void) {
    string subject;
    float weight;
    string mark;
    grade total[20];
    float weight_sum = 0, normal_sum = 0, avg;
    for (int i = 0; i < 20; i++) {
        cin >> subject >> weight >> mark;
        total[i] = grade(subject, weight, mark);
    }
    for (int i = 0; i < 20; i++) {
        weight_sum += total[i].weight * total[i].mark;
        normal_sum += total[i].weight;
    }
    avg = weight_sum / normal_sum;
    cout << fixed;
    cout.precision(6);
    cout << avg;
}