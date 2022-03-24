#ifndef CGCOLORCHANGEEVENT_H
#define CGCOLORCHANGEEVENT_H

#include "../CgBase/CgBaseEvent.h"
#include "../CgBase/CgEnums.h"
#include <string>
#include <iostream>

class CgColorChangeEvent : public CgBaseEvent
{
public:
    CgColorChangeEvent();
    CgColorChangeEvent(Cg::EventType type, std::string text, int red, int green, int blue);
    ~CgColorChangeEvent();

    //inherited
    Cg::EventType  getType();
    CgBaseEvent* clone();

    //own specific methods
    std::string text() const;

    friend std::ostream& operator <<(std::ostream& os, const CgColorChangeEvent& e);

private:

    Cg::EventType m_type;
    std::string m_text;
    int m_red;
    int m_green;
    int m_blue;
};

#endif // CGCOLORCHANGEEVENT_H
